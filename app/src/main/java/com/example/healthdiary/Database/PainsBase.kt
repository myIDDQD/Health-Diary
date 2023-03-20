import androidx.room.*
import com.example.healthdiary.Database.BodyParts
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity(
    tableName = "pains_base",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(
            entity = BodyParts::class,
            parentColumns = ["id"],
            childColumns = ["body_parts"]
        )
    ]
)
data class PainsBase(
    @PrimaryKey(autoGenerate = true) val id: Int,
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
