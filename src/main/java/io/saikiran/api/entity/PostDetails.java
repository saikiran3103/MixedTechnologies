package io.saikiran.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class PostDetails {
 
    @Id
    private Long id;
 
   
 
    private boolean visible;
 
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Post post;
 
    public Long getId() {
        return id;
    }
 
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
 
    public void setPost(Post post) {
        this.post = post;
    }
}