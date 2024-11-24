package online.jutter.cow.domain.uscaseses.news



import online.jutter.cow.data.db.repositories.NewsRepository


class GetAllNewsUseCase {

    operator fun invoke() = NewsRepository.getAll()
}