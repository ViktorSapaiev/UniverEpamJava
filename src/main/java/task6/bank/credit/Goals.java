package task6.bank.credit;

public enum Goals {
    BUYHOUSE(1, "На покупку жилья.", 9.0f),
    BUYVEHICLE(2, "На покупку транспортного средства.", 7.0f),
    BUYHOUSEHOLDPRODUCTS(3, "На покупку товаров для дома(мебель и бытовая техника).", 5.0f),
    BUYGADGETS(4, "На покупку гаджетов (мобильные телфоны, ноутбуки, персональные компьютеры).", 3.0f),
    STUDYCREDIT(5, "На оплату обучения.", 4.0f);

    private String goal;
    private int id;
    private float percent;
    Goals(int id, String goal, float percent) {
        this.goal = goal;
        this.id = id;
        this.percent = percent;
    }

    public static Goals getById(int id) {
        for (Goals result : Goals.values()) {
            if (id == result.getId()) {
                return result;
            }
        }
        throw new IllegalArgumentException("Goal with id " + id + " is not found");
    }

    public String getGoal() {
        return goal;
    }

    public int getId() {
        return id;
    }

    public float getPercent() {
        return percent;
    }


    @Override
    public String toString() {
        return "Goals{" +
                "goal='" + goal + '\'' +
                ", id=" + id +
                '}';
    }
}