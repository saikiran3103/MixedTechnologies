package io.saikiran.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Post  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String name;

@OneToOne(mappedBy = "post",
    cascade = CascadeType.ALL, orphanRemoval = true)
private PostDetails details;

public Long getId() {
    return id;
}

public PostDetails getDetails() {
    return details;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public void addDetails(PostDetails details) {
    this.details = details;
    details.setPost(this);
}

public void removeDetails() {
    if (details != null) {
        details.setPost(null);
    }
    this.details = null;
}
}