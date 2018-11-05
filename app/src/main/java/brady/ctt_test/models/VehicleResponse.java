package brady.ctt_test.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kieronbrady on 04/11/2018.
 */

/** VehicleResponse class - the information pertaining to the Vehicle API*/
public class VehicleResponse {
    @SerializedName("count")
    private int count;
    @SerializedName("vehicles")
    private List<Vehicle> results;
    @SerializedName("currentPage")
    private int currentPage;
    @SerializedName("nextPage")
    private int nextPage;
    @SerializedName("totalPages")
    private int totalPages;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Vehicle> getResults() {
        return results;
    }

    public void setResults(List<Vehicle> results) {
        this.results = results;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
