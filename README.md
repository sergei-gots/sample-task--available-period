REST for HTTP GET("http[s]://localhost:8080/available-period") returns JSON with data according to the bizarre task specification (see README.md)

<h2>Requirements</h2>
To develop REST App for calculating the period of reported dates GET /available-period.
Must handle the header "session-token"
Must return JSON-object with the 3 string keys and string arrays with the values.
<br>
Result example:
<code>
{

"2022":["31 декабря 2022", "01 января 2023", "01 февраля 2023", "01 марта 2023", "01 апреля 2023", "01 мая 2023", "01 июня 2023", "01 июля 2023", "01 августа 2023", "01 сентября 2023", "01 октября 2023"],

"2021":["31 декабря 2021", "01 января 2022", "01 февраля 2022", "01 марта 2022", "01 апреля 2022", "01 мая 2022", "01 июня 2022", "01 июля 2022", "01 августа 2022", "01 сентября 2022", "01 октября 2022", "01 ноября 2022", "01 декабря 2022"],

"2020":["31 декабря 2020", "01 января 2021", "01 февраля 2021", "01 марта 2021", "01 апреля 2021", "01 мая 2021", "01 июня 2021", "01 июля 2021", "01 августа 2021", "01 сентября 2021", "01 октября 2021", "01 ноября 2021", "01 декабря 2021"]
}
</code>
<br><br>
REST must be covered with integration tests at least with the next three cases:
<li>First year </li>
<li>Second year </li>
<li>Bounding two years </li>
<br><br>
Test will be passed in 10 years in the future too.
<br><br>
Logic specification
<br>
<li>1. Calculating values for params year_1, year_2, year_3 is based on the value of current calendar year. If there is 2023 now, then we return 3 of years going before: 2022, 2021 and 2020.
   Exception! 31 december 2023 will make 2023 available, and 2020 should disappear (i.e. if there is 31 december 2023 then show 2023, 2022, 2021).  In 2024, besides 31 december 2024, we return values for 2023, 2022 and 2021 годы, etc. as it is the same for the next years.
</li>
<li>2. Calculating values for params of monthDate is based on the values of params year_1, year_2, year_3.
   E.g., today is 27 october 2023, year_1 == 2022, year_2 == 2021, year_3 == 2020, then report dates monthDate must be as shown below:
   <br>
   <br>
   Year_1 == 2022
   <br>
   monthDate (in russian):
<li>31 декабря 2022
<li>01 января 2023
<li>01 февраля 2023
<li>01 марта 2023
<li>01 апреля 2023
<li>01 мая 2023
<li>01 июня 2023
<li>01 июля 2023
<li>01 августа 2023
<li>01 сентября 2023
<li>01 октября 2023
<br>
<br>
   Year_2 == 2021
   <br>
   monthDate:
<li>31 декабря 2021
<li>01 января 2022
<li>01 февраля 2022
<li>01 марта 2022
<li>01 апреля 2022
<li>01 мая 2022
<li>01 июня 2022
<li>01 июля 2022
<li>01 августа 2022
<li>01 сентября 2022
<li>01 октября 2022
<li>01 ноября 2022
<li>01 декабря 2022
<br>
<br>
   Year_3 == 2020
   <br>
   monthDate:
<li>31 декабря 2020
<li>01 января 2021
<li>01 февраля 2021
<li>01 марта 2021
<li>01 апреля 2021
<li>01 мая 2021
<li>01 июня 2021
<li>01 июля 2021
<li>01 августа 2021
<li>01 сентября 2021
<li>01 октября 2021
<li>01 ноября 2021
<li>01 декабря 2021
