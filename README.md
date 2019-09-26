# Back-End

# Login 

POST: https://build-save-the-animals.herokuapp.com/login (OAUTH2)<br>
GET: https://build-save-the-animals.herokuapp.com/users/getuser 

# Sign-up

POST: https://build-save-the-animals.herokuapp.com/createnewuser
```
{
    "username": "username",
    "password": "password",
    "userroles": [
        {
            "role": {
                "roleid": 2,
                "name": "data"  (present for both user types)
            }
        },
        {
            "role": {
                "roleid": 4,
                "name": "organization" OR "supporter"
            }
        }
    ],
    "useremails": [
        {
            "useremail": "email1@email.com"
        },
        {
            "useremail": "email2@mymail.com"
        }
    ]
}
```
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
 ```
    {
       “title”: String,
       “photo”: String,
       “location”: String,
       “description”: String,
       “species”: String,
       “urgency”: String,
       “donations”: Number,
       “funding_goal”: Number,
       “userid”: Number (user id is required)
   }
 ```

* Edit a campaign (user type: organization only)<br>
 PUT: https://build-save-the-animals.herokuapp.com/campaigns/campaign/update/{id}<br>
 (provide any key:value pairs that need updating)<br>
 {<br>
   key: value<br>
 }

* Delete a campaign (user type: organization only)<br>
 DELETE: https://build-save-the-animals.herokuapp.com/campaigns/campaign/delete/{id}


* Make donation<br>
 POST: https://build-save-the-animals.herokuapp.com/campaigns/campaign/donate<br>
  ```
  {
    "amount": Number,
    "userid": Number,
    "campaignid": Number
  }
  ```

  * Filter campaigns by species<br>
  GET: https://build-save-the-animals.herokuapp.com/campaigns/filter/species/{species}


  * Filter campaigns by location<br>
  GET: https://build-save-the-animals.herokuapp.com/campaigns/filter/location/{location}

  * Get campaigns by user<br>
  GET: https://build-save-the-animals.herokuapp.com/campaigns/byuser/{id}
