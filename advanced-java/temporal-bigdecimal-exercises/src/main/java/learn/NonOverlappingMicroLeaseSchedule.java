package learn;

import java.util.ArrayList;

/**
 * A schedule of MicroLeases where no lease can overlap another.
 */
public class NonOverlappingMicroLeaseSchedule {

    // on success, a MicroLease is stored in leases
    private final ArrayList<MicroLease> leases = new ArrayList<>();

    // 1. Complete the add method.

    /**
     * Attempts to add a MicroLease to the Schedule.
     * Rules:
     * - if lease is null, return false
     * - if lease.getStart or lease.getEnd is null, return false
     * - if lease.getStart is later then lease.getEnd, return false
     * - if the lease overlaps any other lease in leases, return false
     * - otherwise, add to leases and return true
     *
     * @param lease - a MicroLease to be added to the schedule.
     * @return true if MicroLease is valid (see rules)
     * false if not valid
     */

    public boolean add(MicroLease lease) {
        // null checks
        if (lease == null || lease.getStart() == null || lease.getEnd() == null) {
            return false;
        }

        // invalid range: start >= end
        if (!lease.getStart().isBefore(lease.getEnd())) {
            return false;
        }

        // overlap check
        for (MicroLease existing : leases) {
            boolean overlaps =
                    lease.getStart().isBefore(existing.getEnd()) &&
                    lease.getEnd().isAfter(existing.getStart());

            if (overlaps) {
                return false;
            }
        }

        // valid: store and return true
        leases.add(lease);
        return true;
    }
}
