package online.simplefoodsolutions.api.domain;

import lombok.Data;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="recipes")
@NamedQueries({
        @NamedQuery(name = "Recipe.findByKeyword", query = "SELECT r FROM Recipe r " +
                "where r.title like :title")
})
@Data
@JsonbPropertyOrder(value = {"id", "title", "description"})
public class Recipe implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column (name = "recipe")
    private String recipeDescription;

    

}