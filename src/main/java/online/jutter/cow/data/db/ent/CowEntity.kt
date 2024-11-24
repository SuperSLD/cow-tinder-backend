package online.jutter.cow.data.db.ent

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cows")
class CowEntity {
    @Id
    var id: String = ""

    @Column(name = "sex")
    var sex: String = ""

    @Column(name = "breed")
    var breed: String = ""

    @Column(name = "birth_date")
    var birthDate: String = ""

    @Column(name = "papa")
    var papa: String = ""

    @Column(name = "mama")
    var mama: String = ""

    @Column(name = "milk_volume")
    var milkVolume: String = ""

    @Column(name = "meat_volume")
    var meatVolume: String = ""

    @Column(name = "inbreeding")
    var inbreeding: String = ""

    @Column(name = "meat_increment")
    var meatIncrement: String = ""

    @Column(name = "health")
    var health: String = ""

    @Column(name = "fertility")
    var fertility: String = ""

    @Column(name = "genetic_value")
    var geneticValue: String = ""
}