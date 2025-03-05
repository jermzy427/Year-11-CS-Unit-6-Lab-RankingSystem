import java.awt.image.PackedColorModel;

public class User {
    private int rank;
    private int progress;

    public User()throws IllegalArgumentException{
        this.rank = -8;
        this.progress = 0;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getRank() {
        return this.rank;
    }




    public void incProgress(int activityRank) throws  IllegalArgumentException{

        int rankDiff =  activityRank - this.rank;

        if (activityRank > 8 || activityRank == 0 || activityRank < -8) {
                throw new IllegalArgumentException("The rank of an activity cannot be less than 8, " +
                        "0, or greater than 8!");
            }

        if (activityRank <= -1 && rank >= 1) {
                rankDiff++;

            }
        else if (activityRank >= 1 && rank <= -1) {
            rankDiff--;

            }

        int points = 0;
        if (rankDiff == -1) {
                points = 1;
            }
        else if(rankDiff == 0){
                points = 3;
            }
        else if (rankDiff > 0){
                points = (10*rankDiff*rankDiff);
            }
        int rank_inc = (progress + points) / 100;
        if (rank + rank_inc >= 0 && rank <= -1) {
            rank_inc++;
        }

        if (rank + rank_inc > 8) {
            rank = 8;
            progress = 100;
        } else if (rank + rank_inc == 8) {
            rank += rank_inc;
            if ((progress + points) > 100) {
                progress = 100;
            } else {
                progress += points;
            }
        } else {
            rank += rank_inc;
            progress = (progress + points) % 100;
        }
    }
    public String toString() {
        return "User{" +
                "rank=" + this.rank +
                ", progress=" + this.progress +
                '}';
    }
}
