package online.jutter.cow.domain.uscaseses.sections

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.SectionEntity
import online.jutter.cow.data.db.repositories.SectionsRepository
import online.jutter.cow.domain.models.section.CreateSection

class SetAllSectionsUseCase {

    operator fun invoke(list: List<CreateSection>) {
        SectionsRepository.setAll(
            list.map { section ->
                SectionEntity().apply {
                    id = getUUID()
                    title = section.title
                    description = section.description
                    schedule = section.schedule
                    cover = section.cover
                    author = section.author
                    subtitle = section.subtitle
                    url = section.link
                }
            }
        )
    }
}