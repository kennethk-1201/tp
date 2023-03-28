package seedu.sudohr.logic.commands.leave;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.sudohr.commons.core.Messages;
import seedu.sudohr.logic.commands.Command;
import seedu.sudohr.logic.commands.CommandResult;
import seedu.sudohr.logic.commands.exceptions.CommandException;
import seedu.sudohr.model.Model;
import seedu.sudohr.model.employee.Employee;
import seedu.sudohr.model.employee.Id;
import seedu.sudohr.model.leave.Leave;
import seedu.sudohr.model.leave.LeaveDate;

/**
 * Adds a employee using it's displayed index to a specific leave using it's
 * displayed index in SudoHR.
 */
public class AddEmployeeToLeaveFromToCommand extends Command {
    public static final String COMMAND_WORD = "addEmployeeLeaveFromTo";

    public static final String DATE_CONSTRAINTS = "start date must be before end date and end date"
            + "must be at most 6 days after start date";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds an employee's leave on days from the start date to end date inclusive in SudoHR .\n";

    // maybe rename to duplicate leave? not sure if the right naming is used here
    public static final String MESSAGE_DUPLICATE_EMPLOYEE = "This employee already has a leave on one of the days"
            + "in SudoHR";
    public static final String MESSAGE_ADD_LEAVE_SUCCESS = "Employee %1$s leave is added on %2$s";

    private final List<LeaveDate> leaveDatesToAdd;
    private final Id employeeId;

    /**
     * Creates an AddEmployeeToLeaveFromToCommand to add the leave for a employee at a
     * specified
     * {@code employeeIndex} on the specified {@code date}
     */
    public AddEmployeeToLeaveFromToCommand(Id employeeId, List<LeaveDate> leaveDates) {
        requireNonNull(employeeId);
        requireNonNull(leaveDates);
        this.leaveDatesToAdd = leaveDates;
        this.employeeId = employeeId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Employee employeeToAdd = model.getEmployee(employeeId);

        if (employeeToAdd == null) {
            throw new CommandException(Messages.MESSAGE_EMPLOYEE_NOT_FOUND);
        }

        List<Leave> leavesToAdd = new ArrayList<Leave>();

        for (int i = 0; i < leaveDatesToAdd.size(); i++) {

            Leave leaveToAdd = new Leave(leaveDatesToAdd.get(i));

            leaveToAdd = model.getInternalLeaveIfExist(leaveToAdd);

            if (leaveToAdd.hasEmployee(employeeToAdd)) {
                throw new CommandException(MESSAGE_DUPLICATE_EMPLOYEE);
            }
            leavesToAdd.add(leaveToAdd);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < leavesToAdd.size(); i++) {
            model.addEmployeeToLeave(leavesToAdd.get(i), employeeToAdd);
            builder.append(String.format(MESSAGE_ADD_LEAVE_SUCCESS, employeeToAdd, leavesToAdd.get(i)) + "\n");
        }

        return new CommandResult(builder.toString());
    }

    // Comparator between leaveDates to check if they are equivalent
    private boolean equalLeaveDates(List<LeaveDate> listComparedTo) {
        for (LeaveDate leaveDate : this.leaveDatesToAdd) {
            if (!listComparedTo.contains(leaveDate)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddEmployeeToLeaveFromToCommand // instanceof handles nulls
                        && equalLeaveDates(leaveDatesToAdd)
                        && employeeId.equals(((AddEmployeeToLeaveFromToCommand) other).employeeId));
    }

}