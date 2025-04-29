package chapter3.labs.lab4;

public enum TaskStatus {
    PENDING {
        @Override
        public TaskStatus nextStatus() {
            return IN_PROGRESS;
        }
    },
    IN_PROGRESS {
        @Override
        public TaskStatus nextStatus() {
            return COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public TaskStatus nextStatus() {
            return ARCHIVED;
        }
    },
    ARCHIVED {
        @Override
        public TaskStatus nextStatus() {
            return PENDING;
        }
    };

    public abstract TaskStatus nextStatus();
}
