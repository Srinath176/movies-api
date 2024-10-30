package dev.srinathg.movies.reviews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;


    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }


    public ObjectId getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }


}
