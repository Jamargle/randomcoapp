package com.jmlb0003.randomcoapp

import com.jmlb0003.randomcoapp.TestData.NetworkUser1.CELL_PHONE1
import com.jmlb0003.randomcoapp.TestData.NetworkUser1.EMAIL1
import com.jmlb0003.randomcoapp.TestData.NetworkUser1.FIRST_NAME
import com.jmlb0003.randomcoapp.TestData.NetworkUser1.LAST_NAME
import com.jmlb0003.randomcoapp.TestData.NetworkUser1.PICTURE_PATH1
import com.jmlb0003.randomcoapp.data.network.servicemodel.LocationInfo
import com.jmlb0003.randomcoapp.data.network.servicemodel.Picture
import com.jmlb0003.randomcoapp.data.network.servicemodel.Registered
import com.jmlb0003.randomcoapp.data.network.servicemodel.UserNameInfo
import com.jmlb0003.randomcoapp.domain.model.Gender
import com.jmlb0003.randomcoapp.domain.model.Location
import com.jmlb0003.randomcoapp.domain.model.User
import java.util.Date

object TestData {

    object User1 {
        val NAME1 = "A name"
        val SURNAME1 = "A surname"
        val EMAIL1 = "An email"
        val PICTURE1 = "A path to a picture"
        val PHONE1 = "1234567"
        val GENDER1 = Gender.Male
        val REGISTERED_DATE1 = Date(1514764800000)  // 01-01-2018 00:00
        val STREET1 = "A street"
        val CITY1 = "A city"
        val STATE1 = "A state"
        val LATITUDE1 = "A latitude"
        val LONGITUDE1 = "A longitude"
        val LOCALTION1 = Location(STREET1, CITY1, STATE1, LATITUDE1, LONGITUDE1)

        val USER = User(NAME1, SURNAME1, EMAIL1, PICTURE1, PHONE1, GENDER1, REGISTERED_DATE1, LOCALTION1, false)
    }

    object User2 {
        val NAME2 = "Another name"
        val SURNAME2 = "Another surname"
        val EMAIL2 = "An email"
        val PICTURE2 = "A path to a picture"
        val PHONE2 = "1234567"
        val GENDER2 = Gender.Female
        val REGISTERED_DATE2 = Date(1514764800000)  // 01-01-2018 00:00
        val STREET2 = "A street"
        val CITY2 = "A city"
        val STATE2 = "A state"
        val LATITUDE2 = "A latitude"
        val LONGITUDE2 = "A longitude"
        val LOCALTION2 = Location(STREET2, CITY2, STATE2, LATITUDE2, LONGITUDE2)

        val USER = User(NAME2, SURNAME2, EMAIL2, PICTURE2, PHONE2, GENDER2, REGISTERED_DATE2, LOCALTION2, false)
    }

    object ListOfRepeatedUsers {
        val users = listOf(User1.USER, User1.USER)
    }

    object ListOfNonRepeatedUsers {
        val users = listOf(User1.USER, User2.USER)
    }

    object NetworkUser1 {
        val TITLE = "a title"
        val FIRST_NAME = "first name"
        val LAST_NAME = "last name"
        val NAME1 = UserNameInfo(TITLE, FIRST_NAME, LAST_NAME)
        val EMAIL1 = "asdasdas@asdasdas.com"
        val PICTURE_PATH1 = "A path to a picture"
        val PICTURE1 = Picture(null, PICTURE_PATH1, null)
        val CELL_PHONE1 = "1234567"
        val REGISTERED_DATE1 = Registered("2018-01-01T00:0047Z", null)  // 01-01-2018 00:00
        val STREET1 = "A street"
        val CITY1 = "A city"
        val STATE1 = "A state"
        val LOCALTION1 = LocationInfo(STREET1, CITY1, STATE1, null, null, null)

        val USER = com.jmlb0003.randomcoapp.data.network.servicemodel.User("male",
                NAME1,
                LOCALTION1,
                EMAIL1,
                null,
                null,
                REGISTERED_DATE1,
                null,
                CELL_PHONE1,
                null,
                PICTURE1,
                null)
    }

    object ListOfNetworkUsers {
        val users = listOf(NetworkUser1.USER, NetworkUser1.USER)
    }

    object ListOfNetworkParsedUsers {
        val expectedUser1 = User(name = FIRST_NAME,
                surname = LAST_NAME,
                email = EMAIL1,
                picture = PICTURE_PATH1,
                phone = CELL_PHONE1,
                gender = Gender.Male,
                registeredDate = Date(1514764800000),
                location = Location(
                        NetworkUser1.STREET1,
                        NetworkUser1.CITY1,
                        NetworkUser1.STATE1, null, null))
        val users = listOf(expectedUser1, expectedUser1)
    }

}