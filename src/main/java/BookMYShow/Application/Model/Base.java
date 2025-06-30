package BookMYShow.Application.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Enables auditing
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreatedDate
    @Column(updatable = false) // Prevents modification after creation
    private Date createdAt;
    @LastModifiedDate
    private Date lastModifiedAt;
}
