const BASE_URL = "http://localhost:9092/vgro.bank.in";

async function createAccount() {
  const name = document.getElementById("createName").value;
  const balance = document.getElementById("createBalance").value;

  const response = await fetch(`${BASE_URL}/create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ account_holder_name: name, account_balance: balance })
  });

  const data = await response.json();
  alert("Account Created: " + JSON.stringify(data));
}

async function getAccount() {
  const accountNumber = document.getElementById("getAccountNumber").value;
  const response = await fetch(`${BASE_URL}/${accountNumber}`);
  const data = await response.json();
  document.getElementById("accountDetails").textContent = JSON.stringify(data, null, 2);
}

async function getAllAccounts() {
  const response = await fetch(`${BASE_URL}/getallaccounts`);
  const data = await response.json();
  document.getElementById("allAccounts").textContent = JSON.stringify(data, null, 2);
}

async function depositMoney() {
  const accountNumber = document.getElementById("depositAccountNumber").value;
  const amount = document.getElementById("depositAmount").value;

  const response = await fetch(`${BASE_URL}/deposite/${accountNumber}/${amount}`, { method: "PUT" });
  const data = await response.json();
  alert("Deposit Successful: " + JSON.stringify(data));
}

async function withdrawMoney() {
  const accountNumber = document.getElementById("withdrawAccountNumber").value;
  const amount = document.getElementById("withdrawAmount").value;

  const response = await fetch(`${BASE_URL}/withdraw/${accountNumber}/${amount}`, { method: "PUT" });
  const data = await response.json();
  alert("Withdrawal Successful: " + JSON.stringify(data));
}

async function closeAccount() {
  const accountNumber = document.getElementById("deleteAccountNumber").value;
  const response = await fetch(`${BASE_URL}/delete/${accountNumber}`, { method: "DELETE" });
  const message = await response.text();
  alert(message);
}