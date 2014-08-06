$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/eVillage/rest/accounts"
    }).then(function(data) {
       $('.accounts-firstName').append(data.firstName);
       $('.accounts-lastName').append(data.lastName);
       $('.accounts-middleName').append(data.middleName);
       $('.accounts-userName').append(data.userName);
       $('.accounts-emailId').append(data.emailId);
       $('.accounts-dob').append(data.dob);
       $('.accounts-phNo').append(data.phNo);
    });
});

