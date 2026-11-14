import java.util.*;

public class question1 {

    interface Dimmable {
        void dim(int level);
    }

    interface Schedulable {
        void schedule(String time);
    }

    interface EnergyMonitorable {
        String getEnergy();
    }

    static abstract class SmartDevice {
        String id;
        boolean isOn;

        SmartDevice(String id) {
            this.id = id;
            this.isOn = false;
        }

        void turnOn() {
            isOn = true;
            System.out.println(id + " is ON");
        }

        void turnOff() {
            isOn = false;
            System.out.println(id + " is OFF");
        }
    }

    static class SmartLight extends SmartDevice implements Dimmable, Schedulable {
        SmartLight(String id) {
            super(id);
        }

        @Override
        public void dim(int level) {
            System.out.println(id + " dimmed to " + level);
        }

        @Override
        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class SmartFan extends SmartDevice implements Schedulable {
        SmartFan(String id) {
            super(id);
        }

        @Override
        public void schedule(String time) {
            System.out.println(id + " scheduled " + time);
        }
    }

    static class SmartPlug extends SmartDevice implements EnergyMonitorable {
        String energyUsage;

        SmartPlug(String id, String energyUsage) {
            super(id);
            this.energyUsage = energyUsage;
        }

        @Override
        public String getEnergy() {
            return energyUsage;
        }
    }

    static class SmartHomeController {
        Map<String, SmartDevice> devices = new HashMap<>();

        void addDevice(SmartDevice device) {
            devices.put(device.id, device);
        }

        void executeCommand(String commandLine) {
            String[] parts = commandLine.split("\\s+");
            String action = parts[0].toUpperCase();
            String deviceId = parts[1];

            SmartDevice device = devices.get(deviceId);
            if (device == null) {
                System.out.println(deviceId + " not found");
                return;
            }

            switch (action) {
                case "ON":
                    device.turnOn();
                    break;
                case "OFF":
                    device.turnOff();
                    break;
                case "DIM":
                    if (device instanceof Dimmable) {
                        int level = Integer.parseInt(parts[2]);
                        ((Dimmable) device).dim(level);
                    } else {
                        System.out.println(deviceId + " rejected: DIM unsupported");
                    }
                    break;
                case "SCHEDULE":
                    if (device instanceof Schedulable) {
                        ((Schedulable) device).schedule(parts[2]);
                    } else {
                        System.out.println(deviceId + " rejected: SCHEDULE unsupported");
                    }
                    break;
                case "ENERGY":
                    if (device instanceof EnergyMonitorable) {
                        System.out.println(deviceId + " energy " + ((EnergyMonitorable) device).getEnergy());
                    } else {
                        System.out.println(deviceId + " rejected: ENERGY unsupported");
                    }
                    break;
                default:
                    System.out.println(deviceId + " rejected: " + action + " unsupported");
            }
        }
    }

    public static void main(String[] args) {
        SmartHomeController home = new SmartHomeController();

        // Devices from sample input
        home.addDevice(new SmartLight("L1"));
        home.addDevice(new SmartFan("F1"));
        home.addDevice(new SmartPlug("P1", "12 kWh"));

        // Commands from sample input
        String[] commands = {
            "ON L1",
            "DIM L1 40",
            "DIM F1 30",
            "SCHEDULE F1 22:00",
            "ENERGY P1",
            "ENERGY L1"
        };

        for (String cmd : commands) {
            home.executeCommand(cmd);
        }
    }
}