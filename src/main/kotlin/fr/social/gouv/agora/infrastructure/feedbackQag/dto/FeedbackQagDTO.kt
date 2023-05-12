package fr.social.gouv.agora.infrastructure.feedbackQag.dto

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.util.*

@Entity(name = "feedbacks_qag")
data class FeedbackQagDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
    val id: UUID,
    @JoinTable(joinColumns = [JoinColumn(table = "agora_users", referencedColumnName = "id")])
    val userId: UUID,
    @JoinTable(joinColumns = [JoinColumn(table = "qags", referencedColumnName = "id")])
    val qagId: UUID,
    @Column(columnDefinition = "SMALLINT")
    val isHelpful: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as FeedbackQagDTO

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , userId = $userId , qagId = $qagId , isHelpful = $isHelpful )"
    }
}