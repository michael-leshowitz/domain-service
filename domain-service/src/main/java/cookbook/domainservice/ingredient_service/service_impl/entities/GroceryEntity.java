package cookbook.domainservice.ingredient_service.service_impl.entities;

import java.util.ArrayList;

import cookbook.domainservice.tag_management_service.service_impl.entities.TagEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Grocery")
public class GroceryEntity {
    @Id
    @Column(name = "idGrocery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    // TODO: Figure out how to store these JSON properties

    @ManyToMany
    @JoinTable(
        name = "grocery_tags",
        joinColumns = @JoinColumn(name = "groceryId"),
        inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private ArrayList<TagEntity> tags;
}
