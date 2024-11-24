package online.jutter.cow.domain.uscaseses.sections

import online.jutter.cow.data.db.ent.SectionEntity
import online.jutter.cow.data.db.getAll
import online.jutter.cow.data.db.repositories.SectionsRepository
import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.domain.models.section.SectionResponse

class GetAllSectionsUseCase {

    operator fun invoke() = SectionsRepository.executeTransaction {
        getAll<SectionEntity>().map {
            val user = UsersRepository.getById(it.author)!!
            SectionResponse(
                title = it.title,
                subtitle = it.subtitle,
                description = it.description,
                cover = it.cover,
                schedule = it.schedule,
                link = it.url,
                author = user.name + " " + user.lastname,
                authorAvatar = user.avatar ?: ""
            )
        }
    }
}