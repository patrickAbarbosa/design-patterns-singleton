package Braking;

public class BrakeManager {
    private static BrakeManager instance;
    private double brakePowerPercentage;
    private boolean isParking;

    private BrakeManager() {
        brakePowerPercentage = 100;
        isParking = true;
    }

    public static BrakeManager getInstance() {
        if (instance == null) {
            instance = new BrakeManager();
        }

        return instance;
    }

    public boolean getIsParking() {
        return isParking;
    }

    public void parking() {
        isParking = true;
        brakePowerPercentage = 100;
    }

    public void drive() {
        isParking = false;
        brakePowerPercentage = 0;
    }

    public double getBrakePowerPercentage() {
        return brakePowerPercentage;
    }

    private double getNewBrakePowerPercentage(double newBrakePowerPercentage) {
        if (newBrakePowerPercentage < 0) {
            return 0;
        } else if (newBrakePowerPercentage > 100) {
            return 100;
        }

        return newBrakePowerPercentage;
    }

    public void applyBrakes(double newBrakePowerPercentage) {
        brakePowerPercentage = getNewBrakePowerPercentage(newBrakePowerPercentage);
    }
}
