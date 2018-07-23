package ru.job4j.banktransfer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh.
 * @since 23.07.2018.
 */
public class UserAccountsTest {

    private User userFirst;
    private User userSecond;
    private Account accountFirst;
    private Account accountSecond;

    @Before
    public void createData() {
        userFirst = new User("Bob", "passport");
        userSecond = new User("Bob2", "passport2");
        accountFirst = new Account(100d, "1234567890");
        accountSecond = new Account(1000d, "9234567890");
    }

    @Test
    public void whenAddSameUser() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addUser(userFirst);
        List<User> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.getUserAccounts().entrySet()) {
            result.add(entry.getKey());
        }
        List<User> expect = new ArrayList<>();
        expect.add(userFirst);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteUser() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addUser(userSecond);
        userAccounts.deleteUser(userSecond);
        List<User> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.getUserAccounts().entrySet()) {
            result.add(entry.getKey());
        }
        List<User> expect = new ArrayList<>();
        expect.add(userFirst);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteUserWithAccounts() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addUser(userSecond);
        userAccounts.addAccountToUser(userSecond.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userSecond.getPassport(), accountSecond);
        userAccounts.deleteUser(userSecond);
        List<User> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.getUserAccounts().entrySet()) {
            result.add(entry.getKey());
        }
        List<User> expect = new ArrayList<>();
        expect.add(userFirst);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddAccounts() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountSecond);
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.getUserAccounts().entrySet()) {
            result = entry.getValue();
        }
        List<Account> expect = new ArrayList<>();
        expect.add(accountFirst);
        expect.add(accountSecond);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteAccounts() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountSecond);
        userAccounts.deleteAccountFromUser(userFirst.getPassport(), accountSecond);
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.getUserAccounts().entrySet()) {
            result = entry.getValue();
        }
        List<Account> expect = new ArrayList<>();
        expect.add(accountFirst);
        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferEnoughfMoneyThenTrue() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountSecond);
        userAccounts.addUser(userSecond);
        userAccounts.addAccountToUser(userSecond.getPassport(), accountFirst);
        boolean result = userAccounts.transferMoney(userFirst.getPassport(), accountFirst.getRequisites(),
                userSecond.getPassport(), accountFirst.getRequisites(), 90d);
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferNotEnoughfMoneyThenFalse() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountSecond);
        userAccounts.addUser(userSecond);
        userAccounts.addAccountToUser(userSecond.getPassport(), accountFirst);
        boolean result = userAccounts.transferMoney(userFirst.getPassport(), accountFirst.getRequisites(),
                userSecond.getPassport(), accountFirst.getRequisites(), 190d);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferfMoneyToUnattachedAccountThenFalse() {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.addUser(userFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountFirst);
        userAccounts.addAccountToUser(userFirst.getPassport(), accountSecond);
        userAccounts.addUser(userSecond);
        userAccounts.addAccountToUser(userSecond.getPassport(), accountFirst);
        boolean result = userAccounts.transferMoney(userFirst.getPassport(), accountFirst.getRequisites(),
                userSecond.getPassport(), accountSecond.getRequisites(), 90d);
        assertThat(result, is(false));
    }
}
