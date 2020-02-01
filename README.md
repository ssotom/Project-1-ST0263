# Backend
**Maven dependencies:**

- spring-boot-starter-data-mongodb
- spring-boot-starter-data-web
- spring-boot-starter-data-security
- jjwt

**DB:** MongoDB

Navigate to http://localhost:8080/
### Auth
**`[POST] api/auth/user/login`**

**Body request:**
```json
{
	"username": "ssotom",
	"password": "example123"
}
```
**Body response:**
```json
{
    "username": "ssotom",
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ],
    "access_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzc290b20iLCJpYXQiOjE1ODA1MjU1NzEsImV4cCI6MTU4MDUzNDIxMX0.YaXJBzeUD7dduj85Y1phELNw3L3RJ_2jhLijrythv6r2M1nHERqSZtM_QPxLMHRwsGOpqtFEL84d4vE8lZHeBQ"
}
```
**`[POST] api/auth/sensor/register`** :closed_lock_with_key: *requires **admin** authentication*

**Header request:**
```json
{
    "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzc290b20iLCJpYXQiOjE1ODA1MjU1NzEsImV4cCI6MTU4MDUzNDIxMX0.YaXJBzeUD7dduj85Y1phELNw3L3RJ_2jhLijrythv6r2M1nHERqSZtM_QPxLMHRwsGOpqtFEL84d4vE8lZHeBQ"
}
```
**Body response:**
```json
{
    "id": "9ef1977d-9133-40bd-8c44-88a2ab63689e",
    "access_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1ZjMyYWU4OS1hYTFkLTQ1OTktOTkxNy05YmVmOTA1MTcxMjAiLCJpYXQiOjE1ODA1MTEyODAsImV4cCI6MTU5NjA2MzI4MH0.LvO5aFe2r_TzVNJmFFW16hdEztCp-Lpw_5uMH17ES-TEvoux7ZUURsnNsyJgk0T7-ntPjOLvVzuFk9kGarEh2w",
    "expiration_date": "2020-07-30T02:55:55.927+0000"
}
```
### Data
**`[GET] api/sensors`** :closed_lock_with_key: *requires **admin** authentication*

**Header request:**
```json
{
    "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzc290b20iLCJpYXQiOjE1ODA1MjU1NzEsImV4cCI6MTU4MDUzNDIxMX0.YaXJBzeUD7dduj85Y1phELNw3L3RJ_2jhLijrythv6r2M1nHERqSZtM_QPxLMHRwsGOpqtFEL84d4vE8lZHeBQ"
}
```

**Body response:**
```json
[
    {
        "id": "5f32ae89-aa1d-4599-9917-9bef90517120",
        "access_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1ZjMyYWU4OS1hYTFkLTQ1OTktOTkxNy05YmVmOTA1MTcxMjAiLCJpYXQiOjE1ODA1MTEyODAsImV4cCI6MTU5NjA2MzI4MH0.LvO5aFe2r_TzVNJmFFW16hdEztCp-Lpw_5uMH17ES-TEvoux7ZUURsnNsyJgk0T7-ntPjOLvVzuFk9kGarEh2w",
        "expiration_date": "2020-07-29T22:54:40.922+0000"
    }
]
```
**`[POST] api/sensors/data`** :closed_lock_with_key: *requires **sensor** authentication*

**Header request:**
```json
{
    "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1ZjMyYWU4OS1hYTFkLTQ1OTktOTkxNy05YmVmOTA1MTcxMjAiLCJpYXQiOjE1ODA1MTEyODAsImV4cCI6MTU5NjA2MzI4MH0.LvO5aFe2r_TzVNJmFFW16hdEztCp-Lpw_5uMH17ES-TEvoux7ZUURsnNsyJgk0T7-ntPjOLvVzuFk9kGarEh2w"
}
```
**Body request:**
```json
{
	"temperature": 21.5,
	"humidity": 96.6,
	"latitude": 6.217728,
	"longitude":-75.5859456
}
```

**Body response:**
```json
{
    "id": "5e34edbbe61b1f71eec15bb9",
    "temperature": 21.5,
    "humidity": 96.6,
    "latitude": 6.217728,
    "longitude": -75.5859456,
    "sensor": "5f32ae89-aa1d-4599-9917-9bef90517120",
    "created_at": "2020-02-01T03:17:15.067+0000"
}
```

**`[GET] api/sensors/data`** :closed_lock_with_key: *requires **admin** authentication*

**Header request:**
```json
{
    "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzc290b20iLCJpYXQiOjE1ODA1MjU1NzEsImV4cCI6MTU4MDUzNDIxMX0.YaXJBzeUD7dduj85Y1phELNw3L3RJ_2jhLijrythv6r2M1nHERqSZtM_QPxLMHRwsGOpqtFEL84d4vE8lZHeBQ"
}
```
**Body response:**
```json
[
    {
        "id": "5e34edbbe61b1f71eec15bb9",
        "temperature": 21.5,
        "humidity": 96.6,
        "latitude": 6.217728,
        "longitude": -75.5859456,
        "sensor": "5f32ae89-aa1d-4599-9917-9bef90517120",
        "created_at": "2020-02-01T03:17:15.067+0000"
    }
]
```
**`[GET] api/sensors/data/series`**
**Body response:**
```json
[
    {
        "name": "temperature",
        "series": [
            {
                "value": 21.5,
                "name": "Fri Jan 31 18:41:57 COT 2020"
            },
        ]
    },
    {
        "name": "humidity",
        "series": [
            {
                "value": 96.6,
                "name": "Fri Jan 31 18:41:57 COT 2020"
            },
        ]
    }
]
```

# Frontend

**Charting Framework for Angular:** [ngx-charts](https://valor-software.com/ngx-bootstrap/)

**Bootstrap components powered for Angular:** [ngx-bootstrap](https://swimlane.gitbook.io/ngx-charts/)

### First
In the root folder of the project, run `npm install` 

### Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.
