package org.jhipster.health.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A BloodPressure.
 */
@Entity
@Table(name = "blood_pressure")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "bloodpressure")
public class BloodPressure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "datetime", nullable = false)
    private Instant datetime;

    @Column(name = "systolic")
    private Float systolic;

    @Column(name = "diastolic")
    private Float diastolic;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public BloodPressure datetime(Instant datetime) {
        this.datetime = datetime;
        return this;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public Float getSystolic() {
        return systolic;
    }

    public BloodPressure systolic(Float systolic) {
        this.systolic = systolic;
        return this;
    }

    public void setSystolic(Float systolic) {
        this.systolic = systolic;
    }

    public Float getDiastolic() {
        return diastolic;
    }

    public BloodPressure diastolic(Float diastolic) {
        this.diastolic = diastolic;
        return this;
    }

    public void setDiastolic(Float diastolic) {
        this.diastolic = diastolic;
    }

    public User getUser() {
        return user;
    }

    public BloodPressure user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BloodPressure bloodPressure = (BloodPressure) o;
        if (bloodPressure.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bloodPressure.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BloodPressure{" +
            "id=" + getId() +
            ", datetime='" + getDatetime() + "'" +
            ", systolic=" + getSystolic() +
            ", diastolic=" + getDiastolic() +
            "}";
    }
}
