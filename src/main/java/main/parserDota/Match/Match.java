package main.parserDota.Match;

public class Match {
    private String team1;
    private String team2;
    int countOfMatch;
    private String urlOgMatch;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public void setCountOfMatch(int countOfMatch) {
        this.countOfMatch = countOfMatch;
    }

    public String getUrlOgMatch() {
        return urlOgMatch;
    }

    public void setUrlOgMatch(String urlOgMatch) {
        this.urlOgMatch = urlOgMatch;
    }
}
