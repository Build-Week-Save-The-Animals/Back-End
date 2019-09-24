# Back-End

# Login / SignUp

https://build-save-the-animals.herokuapp.com/login

# Users
Two types/roles:
- organization
- supporter
Note: both user types share 'data' role to get all campaigns data)

Existing users:

User 1
username: organization
password: password

User 2
username: supporter
password: password

# Endpoints
// Get all campaigns (both user types)<br>
 GET: https://build-save-the-animals.herokuapp.com/campaigns/all

// Post a campaign (user type: organization only)<br>
 POST: https://build-save-the-animals.herokuapp.com/campaigns/campaign/add

// Edit a campaign (user type: organization only)<br>
 PUT: https://build-save-the-animals.herokuapp.com/campaigns/campaign/update/{id}

// Delete a campaign (user type: organization only)<br>
 DELETE: https://build-save-the-animals.herokuapp.com/campaigns/campaign/delete/{id}



