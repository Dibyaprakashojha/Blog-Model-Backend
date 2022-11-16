package com.shipthis.blogModel.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogModel {
    @Id
    @GeneratedValue(generator = "blog_id_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "blog_id_generator", sequenceName = "blog_id_generator", initialValue = 1, allocationSize = 1)
    private Integer blogId;
    @Column(length = 50)
    private String blogTitle;
    @Column(length = 200)
    private String blogContent;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate addedAtDate;
}
