package online.jutter.cow

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    csvReader().open("data.csv") {
        readAllAsSequence().forEach { row ->
            sendPost(bodyContent = "{\n" +
                    "    \"id\": \"${row[0]}\",\n" +
                    "    \"sex\": \"${row[1]}\",\n" +
                    "    \"breed\": \"${row[2]}\",\n" +
                    "    \"birthDate\": \"${row[3]}\",\n" +
                    "    \"papa\": \"${row[4]}\",\n" +
                    "    \"mama\": \"${row[5]}\",\n" +
                    "    \"milkVolume\": \"${row[6]}\",\n" +
                    "    \"meatVolume\": \"${row[7]}\",\n" +
                    "    \"inbreeding\": \"${row[8]}\",\n" +
                    "    \"meatIncrement\": \"${row[9]}\",\n" +
                    "    \"health\": \"${row[10]}\",\n" +
                    "    \"fertility\": \"${row[11]}\",\n" +
                    "    \"geneticValue\": \"${row[12]}\"\n" +
                    "}")
            println(row)
        }
    }
}
fun sendPost(urlString: String = "https://jutter.online/cowtinder/api/cow/addcow",
             bodyContent: String = "test") {

    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create(urlString))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(bodyContent))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    val answer = response.body()
    println(answer)
}