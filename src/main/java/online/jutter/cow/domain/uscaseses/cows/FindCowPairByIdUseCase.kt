package online.jutter.cow.domain.uscaseses.cows

import com.example.app_domain.models.cow.CowPairResult
import com.example.app_domain.models.cow.WaitedCowData
import netscape.javascript.JSObject
import online.jutter.cow.data.db.ent.CowEntity
import online.jutter.cow.data.models.CowPairData
import online.jutter.cow.data.models.CowRequest
import org.json.JSONArray
import org.json.JSONObject
import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class FindCowPairByIdUseCase {

    operator fun invoke(params: CowPairData): List<CowPairResult> {
        val resp = sendGetRequest(
            url = "http://bagofpockets.tplinkdns.com:9000/cows/find_partners",
            params = mapOf(
                "target_cow_id" to params.cowTag,
                "category" to CATEGORY_LIST[params.maximisationParam],
                "min_growth" to params.weight[0].toString(),
                "max_growth" to params.weight[1].toString(),
                "min_udo" to params.milk[0].toString(),
                "max_udo" to params.milk[1].toString(),
                "min_health" to params.health[0].toString(),
                "max_health" to params.health[1].toString(),

            ))

        val jsonArray = JSONArray(resp)
        val response = mutableListOf<CowPairResult>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            response.add(
                CowPairResult(
                    otherCow = CowEntity().apply {
                        id = jsonObject["ID_особи"].toString()
                        sex = jsonObject["Пол"].toString()
                        breed = jsonObject["Порода"].toString()
                        birthDate = jsonObject["Дата_Рождения"].toString()
                        papa = jsonObject["Родитель_папа"].toString()
                        mama = jsonObject["Родитель_мама"].toString()
                        milkVolume = jsonObject["Удой л/день"].toString()
                        meatVolume = jsonObject["Упитанность"].toString()
                        inbreeding = jsonObject["Коэффициент инбридинга (F)"].toString()
                        meatIncrement = jsonObject["Прирост веса кг/день"].toString()
                        health = jsonObject["Здоровье (1-10)"].toString()
                        fertility = jsonObject["Фертильность (%)"].toString()
                        geneticValue = jsonObject["Генетическая ценность (баллы)"].toString()
                    },
                    waitedCowData = WaitedCowData(0f, 0f, 0f, 0f)
                )
            )
        }


        //?target_cow_id=1&category=%D0%9F%D1%80%D0%B8%D1%80%D0%BE%D1%81%D1%82%20%D0%B2%D0%B5%D1%81%D0%B0%20%D0%BA%D0%B3%2F%D0%B4%D0%B5%D0%BD%D1%8C&min_growth=0&max_growth=100&min_udo=0&max_udo=100&min_health=1&max_health=10

        return response
    }

    private val CATEGORY_LIST = listOf(
        "Удой л/день", "Упитанность", "Здоровье (1-10)", "Фертильность (%)", "Прирост веса кг/день",
    "Коэффициент инбридинга (F)", "Упитанность", "Генетическая ценность (баллы)"
    )

    fun sendGetRequest(url: String, params: Map<String, String>): String? {
        val paramList = params.map { URLEncoder.encode(it.key, "UTF-8") + "=" + URLEncoder.encode(it.value, "UTF-8") }
        val paramString = paramList.joinToString("&")
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("$url?$paramString"))
            .header("Content-Type", "application/json")
            .GET()
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val answer = response.body()
        println(answer)
        return answer
    }
}