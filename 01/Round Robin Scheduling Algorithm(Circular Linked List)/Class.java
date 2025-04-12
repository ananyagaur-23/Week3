class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = tail;
        do {
            if (curr.pid == pid) {
                if (curr == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        Process curr = head;
        int time = 0;
        int totalWaitingTime = 0, totalTurnAroundTime = 0;
        int count = 0;

        while (head != null) {
            displayProcesses();
            if (curr.remainingTime <= timeQuantum) {
                time += curr.remainingTime;
                totalTurnAroundTime += time;
                totalWaitingTime += time - curr.burstTime;
                removeProcess(curr.pid);
                curr = head;
                count++;
            } else {
                curr.remainingTime -= timeQuantum;
                time += timeQuantum;
                curr = curr.next;
            }
        }

        System.out.println("All processes completed.");
        System.out.println("Average Waiting Time: " + (totalWaitingTime * 1.0 / count));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime * 1.0 / count));
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Process curr = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("PID: " + curr.pid + ", Remaining Time: " + curr.remainingTime + ", Priority: " + curr.priority);
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }
}
