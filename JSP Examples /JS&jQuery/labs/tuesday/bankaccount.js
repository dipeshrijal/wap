"use strict";

var Account = (function () {
    return function () {
        var name = "";
        var deposit = 0;
        return {
            createAccount: function (name, deposit) {
                this.name = name;
                this.deposit = deposit;
            },
            getName: function () {
                return this.name;
            },
            getDeposit: function () {
                return this.deposit;
            },
            displayDetail: function () {
                return "Account name: " + this.getName() + " Balance: " + this.getDeposit() + "\n";
            }
        };
    };
})();

window.onload = function () {
    var btn = document.getElementById("create");
    var acctName = document.getElementById("name");
    var balance = document.getElementById("deposit");
    var details = document.getElementById("details");
    var accountListInfo = [];

    btn.onclick = createAccount;

    function createAccount() {
        if (acctName.value === "" || balance.value === "") {
            alert("Invalid Fields");
            return false;
        }
        var account = new Account();
        account.createAccount(acctName.value, balance.value);
        accountListInfo.push(account);
        details.value = "";
        for (var key in accountListInfo) {
            if (accountListInfo[key] !== undefined) {
                details.value += accountListInfo[key].displayDetail();
            }
        }
        acctName.value = "";
        balance.value = "";
    }
};