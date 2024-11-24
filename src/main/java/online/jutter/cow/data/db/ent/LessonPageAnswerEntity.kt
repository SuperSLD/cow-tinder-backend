package online.jutter.cow.data.db.ent

import javax.persistence.*

@Entity
@Table(name = "lesson_page_answers")
class LessonPageAnswerEntity {

    @Id
    var id: String = ""
    var title: String = ""

    @Column(name = "lesson_page_id")
    var lessonPageId: String = ""
}