package com.shubhit.livescore.model

import com.google.gson.annotations.SerializedName

data class CurrentMatches(

    @SerializedName("apikey" ) var apikey : String?         = null,
    @SerializedName("data"   ) var data   : ArrayList<Data> = arrayListOf(),
    @SerializedName("status" ) var status : String?         = null,
    @SerializedName("info"   ) var info   : Info?           = Info()
)

data class TeamInfo (

    @SerializedName("name"      ) var name      : String? = null,
    @SerializedName("shortname" ) var shortname : String? = null,
    @SerializedName("img"       ) var img       : String? = null

)


data class Score (

    @SerializedName("r"      ) var r      : Int?    = null,
    @SerializedName("w"      ) var w      : Int?    = null,
    @SerializedName("o"      ) var o      : Double?    = null,
    @SerializedName("inning" ) var inning : String? = null

)



data class Data (

    @SerializedName("id"             ) var id             : String?             = null,
    @SerializedName("name"           ) var name           : String?             = null,
    @SerializedName("matchType"      ) var matchType      : String?             = null,
    @SerializedName("status"         ) var status         : String?             = null,
    @SerializedName("venue"          ) var venue          : String?             = null,
    @SerializedName("date"           ) var date           : String?             = null,
    @SerializedName("dateTimeGMT"    ) var dateTimeGMT    : String?             = null,
    @SerializedName("teams"          ) var teams          : ArrayList<String>   = arrayListOf(),
    @SerializedName("teamInfo"       ) var teamInfo       : ArrayList<TeamInfo> = arrayListOf(),
    @SerializedName("score"          ) var score          : ArrayList<Score>    = arrayListOf(),
    @SerializedName("series_id"      ) var seriesId       : String?             = null,
    @SerializedName("fantasyEnabled" ) var fantasyEnabled : Boolean?            = null,
    @SerializedName("bbbEnabled"     ) var bbbEnabled     : Boolean?            = null,
    @SerializedName("hasSquad"       ) var hasSquad       : Boolean?            = null,
    @SerializedName("matchStarted"   ) var matchStarted   : Boolean?            = null,
    @SerializedName("matchEnded"     ) var matchEnded     : Boolean?            = null

)

data class Info (

    @SerializedName("hitsToday"  ) var hitsToday  : Int?    = null,
    @SerializedName("hitsUsed"   ) var hitsUsed   : Int?    = null,
    @SerializedName("hitsLimit"  ) var hitsLimit  : Int?    = null,
    @SerializedName("credits"    ) var credits    : Int?    = null,
    @SerializedName("server"     ) var server     : Int?    = null,
    @SerializedName("offsetRows" ) var offsetRows : Int?    = null,
    @SerializedName("totalRows"  ) var totalRows  : Int?    = null,
    @SerializedName("queryTime"  ) var queryTime  : Double? = null,
    @SerializedName("s"          ) var s          : Int?    = null,
    @SerializedName("cache"      ) var cache      : Int?    = null

)