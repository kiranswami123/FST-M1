interface BicycleParts {
    public int gears = 0;
    public int currentSpeed = 0;
}
interface BicycleOperations {
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}