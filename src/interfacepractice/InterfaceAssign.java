package interfacepractice;

interface SmartDevice {

    void turnOn();
    void performTask();

    default void deviceInfo() {
        System.out.println("Device Info:");
        turnOn();
        performTask();
    }

    static void systemCheck() {
        System.out.println("System check completed successfully.");
    }

    // Nested interface
    interface Battery {

        void charge();
        void checkLevel();

        private void drainBattery() {
            System.out.println("Battery is draining");
        }

        // Default method using private method
        default void batteryStatus() {
            drainBattery();
            checkLevel();
        }
    }
}

public class InterfaceAssign {
    public static void main(String[] args) {

        // Anonymous class implementation of SmartDevice
        SmartDevice device = new SmartDevice() {
            public void turnOn() {
                System.out.println("Smart device is turning ON.");
            }

            public void performTask() {
                System.out.println("Smart device is performing a task.");
            }
        };

        // Anonymous class implementation of nested interface Battery
        SmartDevice.Battery battery = new SmartDevice.Battery() {

            public void charge() {
                System.out.println("Battery is charging");
            }

            public void checkLevel() {
                System.out.println("Battery level is 85%.");
            }
        };

        // Method calls
        SmartDevice.systemCheck();
        device.deviceInfo();
        battery.charge();
        battery.batteryStatus();
    }
}
