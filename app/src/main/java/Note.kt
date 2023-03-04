import java.time.LocalDateTime

class Note(
    val date: LocalDateTime,
    val title: String,
    val text: String
) {
    override fun toString(): String {
        return "Date: $date\nTitle: $title\nText: $text"
    }
}
