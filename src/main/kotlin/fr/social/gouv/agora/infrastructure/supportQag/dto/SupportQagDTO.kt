package fr.social.gouv.agora.infrastructure.supportQag.dto

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.util.UUID

@Entity(name = "supports_qag")
data class SupportQagDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
    val id: UUID,
    @Column(columnDefinition = "TEXT")
    val userId: String,
    @JoinTable(joinColumns = [JoinColumn(name = "qag_id", table = "qags", referencedColumnName = "id")])
    val qagId: UUID,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SupportQagDTO

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , userId = $userId , qagId = $qagId )"
    }
}