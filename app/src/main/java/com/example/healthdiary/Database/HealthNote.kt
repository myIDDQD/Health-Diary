
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

enum class BodyParts(val names: String) {
    HEAD("head"),
    BODY("body"),
    LEGS("legs"),
    HANDS("hands")
}

//class HealthNote(
//    val date: LocalDateTime,
//    val title: String,
//    val bodyParts: BodyParts,
//    val medicine: String,
//    val text: String
//) {
//    override fun toString(): String {
//        return "Date: $date\nTitle: $title\nText: $text"
//    }
//}

@Entity
data class HealthNote(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "body_parts") val bodyParts: BodyParts,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "used_medicine") val usedMedicine: String,
    @ColumnInfo(name = "note") val note: String
) {
    fun getCurrentDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        val currentDate = LocalDateTime.now().format(formatter)
        return currentDate!!
    }



    override fun toString(): String {
        return """
            Date: $date
            Title: $title
            Pain body parts: $bodyParts
            Used medicine: $usedMedicine
            Note: $note
        """.trimIndent()
    }
}
