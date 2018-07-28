package ru.job4j.banktransfer;

import java.util.*;

/**
 * @author Valeriy Gyrievskikh
 * @since 23.07.2018
 */
public class UserAccounts {

    /**
     * Список пользователей со списком их счетов.
     */
    private final Map<User, List<Account>> userAccounts = new HashMap<>();

    /**
     * Метод возвращает список пользователей со списком их счетов.
     *
     * @return Список пользователей со списком их счетов.
     */
    public Map<User, List<Account>> getUserAccounts() {
        return userAccounts;
    }

    /**
     * Метод добавляет пользователя с пуствм списком счетов в список пользователей.
     *
     * @param user Новый пользователь.
     */
    public void addUser(User user) {
        userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из списка.
     *
     * @param user Удаляемый пользователь.
     */
    public void deleteUser(User user) {
        Set<User> keys = userAccounts.keySet();
        for (User key : keys) {
            if (key.equals(user)) {
                userAccounts.remove(key);
                break;
            }
        }
    }

    /**
     * Метод добавляет счет в список счетов указанного пользователя.
     *
     * @param passport Паспортные данные пользователя, которому добавляется счет.
     * @param account  Счет.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                List<Account> listAccounts = entry.getValue();
                listAccounts.add(account);
                break;
            }
        }
    }

    /**
     * Метод удаляет счет из списка счетов указанного пользователя.
     *
     * @param passport Паспортные данные пользователя, у которого удаляется счет.
     * @param account  Счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        Iterator<Map.Entry<User, List<Account>>> it = userAccounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<User, List<Account>> entry = it.next();
            User user = entry.getKey();
            if (user.getPassport().equals(passport)) {
                List<Account> listAccounts = entry.getValue();
                //Больше мест для использования indexOf() не придумал
                if (listAccounts.indexOf(account) != -1) {
                    listAccounts.remove(account);
                }
                break;
            }
        }
    }

    /**
     * Метод возвращает список счетов пользователя.
     *
     * @param passport Паспортные данные пользователя, список счетов которого нужно получить.
     * @return Список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                accounts = entry.getValue();
                break;
            }
        }
        return accounts;
    }

    /**
     * Метод возвращает счет пользователя.
     *
     * @param passport   Паспортные данные пользователя.
     * @param requisites Реквизиты счета.
     * @return Счет пользователя или null.
     */
    public Account getUserAccount(String passport, String requisites) {
        Account userAccount = null;
        ArrayList<Account> userAccounts = (ArrayList<Account>) getUserAccounts(passport);
        if (userAccounts.size() > 0) {
            for (Account account : userAccounts) {
                if (account.getRequisites().equals(requisites)) {
                    userAccount = account;
                    break;
                }
            }
        }
        return userAccount;
    }

    /**
     * Метод переводит деньги с одного счета на другой.
     *
     * @param srcPassport  Паспортные данные пользователя, со счетв которого переводятся деньги.
     * @param srcRequisite Реквизиты счета, с которого переводятся деньги.
     * @param dstPassport  Паспортные данные пользователя, на счет которого переводятся деньги.
     * @param dstRequisite Реквизиты счета, на который переводятся деньги.
     * @param amount       Сумма.
     * @return Истина в случае успешного перевода, иначе ложь.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean complete = false;
        Account srcAccount = getUserAccount(srcPassport, srcRequisite);
        Account dstAccount = getUserAccount(dstPassport, dstRequisite);
        if (srcAccount != null && dstAccount != null) {
            if (srcAccount.getValue() >= amount) {
                complete = true;
            }
        }
        return complete;
    }
}
