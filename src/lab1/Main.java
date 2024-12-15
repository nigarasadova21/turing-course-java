package lab1;

import java.util.Scanner;

public class Main {
    static void showMenu() {
        System.out.println("""
                Press 1 to input movies.
                Press 2 to display movies and ratings.
                Press 3 to input more movies.
                Press 4 to find statistics.
                Press 5 to search for a movie.
                Press 6 to update movie ratings.
                Press 7 to delete a movie.
                Press 8 to sort movies.
                Press 0 to exit.
                """);
    }

    static Movie[] addMovies(int n, Scanner sc, Movie[] movies) {
        Movie[] newMovies = new Movie[movies.length + n];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        for (int i = movies.length; i < newMovies.length; i++) {
            sc.nextLine();
            System.out.print("Enter movie name: ");
            String movieName = sc.nextLine();
            System.out.print("Enter movie rating: ");
            double movieRating = sc.nextDouble();
            Movie movie = new Movie(movieName, movieRating);
            newMovies[i] = movie;
        }
        return newMovies;
    }

    static double findAvgRating(Movie[] movies) {
        double avgRating = 0;
        for (Movie movie : movies) {
            avgRating += movie.getRating();
        }
        avgRating = avgRating / movies.length;
        return avgRating;
    }

    static void moviesWithMaxAndMinRating(Movie[] movies) {
        double maxRating = movies[0].getRating();
        double minRating = movies[0].getRating();
        for (Movie movie : movies) {
            if (movie.getRating() > maxRating) {
                maxRating = movie.getRating();
            }
            if (movie.getRating() < minRating) {
                minRating = movie.getRating();
            }
        }
        System.out.println("The movie with the maximum rating: " + maxRating);
        System.out.println("The movie with the minimum rating: " + minRating);
    }

    static void findMovie(String movieName,Movie[] movies) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                System.out.println("Rating of movie \"" + movieName + "\" is " + movie.getRating());
                return;
            }
        }
        System.out.println("Movie \"" + movieName + "\" not found");
    }

    static void updateMovieRating(String movieName,Movie[] movies,Scanner sc) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                System.out.print("Enter the new rating for the movie \"" + movieName + "\": ");
                movie.setRating(sc.nextDouble());
                return;
            }
        }
        System.out.println("Movie \"" + movieName + "\" not found");
    }

    static Movie[] deleteMovie(String movieName,Movie[] movies) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie \"" + movieName + "\" not found");
            return movies;
        } else {
            System.out.println("Movie \"" + movieName + "\" deleted");
        }
        Movie[] newMovies = new Movie[movies.length - 1];
        for(int i = 0, j = 0; i < movies.length; i++, j++) {
            if(movies[i].getName().equals(movieName)) {
                j--;
                continue;
            }
            newMovies[j] = movies[i];
        }
        return newMovies;
    }

    static Movie[] sortMovies(Movie[] movies) {
        for(int i = 0; i < movies.length - 1; i++) {
            boolean swapped = false;
            for(int j = 0; j < movies.length - i - 1; j++) {
                if(movies[j].getRating() > movies[j + 1].getRating()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                return movies;
            }
        }
        return movies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[0];
        showMenu();
        while (true) {
            String movieName;
            int userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    movies = addMovies(3, sc, movies);
                    break;
                case 2:
                    for (Movie movie : movies) {
                        System.out.println(movie.toString());
                    }
                    break;
                case 3:
                    System.out.println("How many additional movies you want to add?");
                    int numberOfMovies = sc.nextInt();
                    movies = addMovies(numberOfMovies, sc, movies);
                    break;
                case 4:
                    System.out.println("The average rating of all movies: " + findAvgRating(movies));
                    moviesWithMaxAndMinRating(movies);
                    break;
                case 5:
                    System.out.print("Enter the movie name you are searching for: ");
                    sc.nextLine();
                    movieName = sc.nextLine();
                    findMovie(movieName, movies);
                    break;
                case 6:
                    System.out.print("Enter the name of the movie whose rating you wish to update: ");
                    sc.nextLine();
                    movieName = sc.nextLine();
                    updateMovieRating(movieName, movies, sc);
                    break;
                case 7:
                    System.out.print("Enter the name of the movie that you want to delete: ");
                    sc.nextLine();
                    movieName = sc.nextLine();
                    movies = deleteMovie(movieName, movies);
                    break;
                case 8:
                    movies = sortMovies(movies);
                    System.out.println("List sorted!!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

