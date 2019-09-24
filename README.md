# Back-End

# Login / SignUp

https://build-save-the-animals.herokuapp.com/login

# Users
Two types/roles:<br>
- organization<br>
- supporter<br>
Note: both user types share 'data' role to get all campaigns data)

Existing users:

User 1<br>
username: organization<br>
password: password

User 2<br>
username: supporter<br>
password: password

# Endpoints
* Get all campaigns (both user types)<br>
 GET: https://build-save-the-animals.herokuapp.com/campaigns/all

* Post a campaign (user type: organization only)<br>
 POST: https://build-save-the-animals.herokuapp.com/campaigns/campaign/add

* Edit a campaign (user type: organization only)<br>
 PUT: https://build-save-the-animals.herokuapp.com/campaigns/campaign/update/{id}

* Delete a campaign (user type: organization only)<br>
 DELETE: https://build-save-the-animals.herokuapp.com/campaigns/campaign/delete/{id}



