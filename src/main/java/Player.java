import java.util.Objects;

public class Player {
    // Encapsulated state
    private String name;
    private int maxHp;
    private int currentHp;
    private int attackPower;
    private int gold;

    // ==========================================
    // CONSTRUCTORS
    // ==========================================

    /**
     * Full parameterized constructor.
     * Sets all fields directly with boundary validation.
     */
    public Player(String name, int maxHp, int currentHp, int attackPower, int gold) {
        this.name = (name == null || name.isBlank()) ? "Default" : name.trim();
        this.maxHp = Math.max(1, maxHp);
        // Clamp current HP between 0 and maxHp
        this.currentHp = Math.clamp(currentHp, 0, this.maxHp);
        this.attackPower = Math.max(0, attackPower);
        this.gold = Math.max(0, gold);
    }

    /**
     * Standard constructor: sets currentHp equal to maxHp, starting gold to 0.
     * Chains to the full constructor using this(...).
     */
    public Player(String name, int maxHp, int attackPower) {
        this(name, maxHp, maxHp, attackPower, 0);
    }

    /**
     * Minimal constructor: uses default RPG base stats.
     * Chains to the 3-parameter constructor.
     */
    public Player(String name) {
        this(name, 100, 15);
    }

    /**
     * Default no-argument constructor: fully default character.
     */
    public Player() {
        this("Adventurer");
    }

    /**
     * Copy constructor: creates a fresh, independent clone of an existing Player.
     */
    public Player(Player other) {
        this(other.name, other.maxHp, other.currentHp, other.attackPower, other.gold);
    }

    // ==========================================
    // GETTERS & SETTERS
    // ==========================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name.trim();
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = Math.max(1, maxHp);
        // Ensure current HP does not exceed new maximum
        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        // Enforce valid HP boundaries: [0, maxHp]
        this.currentHp = Math.clamp(currentHp, 0, this.maxHp);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = Math.max(0, attackPower);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = Math.max(0, gold);
    }

    // ==========================================
    // DOMAIN & CONVENIENCE METHODS
    // ==========================================

    public void takeDamage(int damage) {
        if (damage > 0) {
            setCurrentHp(this.currentHp - damage);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            setCurrentHp(this.currentHp + amount);
        }
    }

    public void addGold(int amount) {
        if (amount > 0) {
            this.gold += amount;
        }
    }

    public boolean spendGold(int amount) {
        if (amount > 0 && this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return this.currentHp > 0;
    }

    // ==========================================
    // STANDARD OVERRIDES (toString, equals, hashCode)
    // ==========================================

    @Override
    public String toString() {
        return String.format(
                "Player[name='%s', HP=%d/%d, attackPower=%d, gold=%d]",
                name, currentHp, maxHp, attackPower, gold
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player other)) return false;
        return maxHp == other.maxHp &&
                currentHp == other.currentHp &&
                attackPower == other.attackPower &&
                gold == other.gold &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxHp, currentHp, attackPower, gold);
    }
}