# Back-End

# Login 

POST: https://build-save-the-animals.herokuapp.com/login (OAUTH2)<br>
GET: https://build-save-the-animals.herokuapp.com/users/getuser 

# Sign-up


# Users
Two types/roles:<br>
- organization<br>
- supporter<br>
Note: both user types share 'data' role to get all campaigns data

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
 POST: https://build-save-the-animals.herokuapp.com/campaigns/campaign/add<br>
    {<br>
       “title”: String,<br>
       “photo”: String,<br>
       “location”: String,<br>
       “description”: String,<br>
       “species”: String,<br>
       “urgency”: String,<br>
       “donations”: Number,<br>
       “funding_goal”: Number,<br>
       “userid”: Number (user id is required)<br>
   }

* Edit a campaign (user type: organization only)<br>
 PUT: https://build-save-the-animals.herokuapp.com/campaigns/campaign/update/{id}<br>
 (provide any key:value pairs that need updating)<br>
 {<br>
   key: value<br>
 }

* Delete a campaign (user type: organization only)<br>
 DELETE: https://build-save-the-animals.herokuapp.com/campaigns/campaign/delete/{id}



