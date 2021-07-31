package com.dot.freelance.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDomain implements EntityID<String> {
    @Id
    @GeneratedValue(generator = SEQ_GEN_UUID)
    @GenericGenerator(name = SEQ_GEN_UUID, strategy = SEQ_GEN_UUID)
    private String id;

    @CreatedBy
    private String createBy;

    private LocalDateTime createAt;

    @LastModifiedBy
    private String modifyBy;

    @LastModifiedDate
    private LocalDateTime modifyAt;

    private Boolean isDeleted;

    @PrePersist
    public void prePersist() {
        if (this.createAt == null)
            this.createAt = LocalDateTime.now();
        this.isDeleted = false;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


    public BaseDomain(String id, LocalDateTime createAt, LocalDateTime modifyAt, Boolean isDeleted) {
        this.id = id;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
        this.isDeleted = isDeleted;
    }
}
