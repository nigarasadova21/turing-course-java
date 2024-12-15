package lab1;

public class Movie {
    String name;
    double rating;

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name= name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "Movie{" +
                "name='" + name+ '\'' +
                ", rating=" + rating +
                '}';
    }
}

