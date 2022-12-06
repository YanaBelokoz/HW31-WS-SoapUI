package AllUseModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter

public class Query {
    public String orderType;
    public int page;
    public boolean pagination;
    public int size;
    public String sortBy;

    public Query() {
        this.page = 1;
        this.pagination = true;
        this.size = 10;
    }

    public Query (int page, boolean pagination, int size) {
        this.page = page;
        this.pagination = pagination;
        this.size = size;
    }
}
