public class Player {
    private int total, bet;
    private int wins, losses;

    private String name;

    public Player(String name) {
        this.name = name;
        this.total = 500;
        this.wins = 0;
        this.losses = 0;
    }

    // todo: gamble function
    public void gamble(int amount) {
        this.bet = amount;

    }

    // setters
    public void win(double payoutRatio) {
        this.wins += 1;
        this.total += this.bet * payoutRatio;
    }

    public void lose(double payoutRatio) {
        this.losses += 1;
        this.total += this.bet * payoutRatio;
    }

    // getters
    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getTotal() {
        return this.total;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return ("Player " + this.name + " has a total earning of " + this.total + " with " + this.wins + " wins and " + this.losses + " losses.");
    }
}
