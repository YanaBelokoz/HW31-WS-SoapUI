package AllUseModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter

public class Models {
    public Integer genreId;
    public String name;
    public String description;

    public int modelsId;
}
