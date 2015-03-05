try {
    ArrayList<Bike> fullBikeList = new ArrayList<>();
    Bike aBike = new Bike(1, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(2, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(3, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(4, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(5, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(6, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);
    aBike = new Bike(7, "Best Buddies", false);
    aBike.save();
    fullBikeList.add(aBike);

    ArrayList<Bike> fullBikeList1 = new ArrayList<>();
    aBike = new Bike(1, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(2, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(3, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(4, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(5, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(6, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);
    aBike = new Bike(7, "Best Buddies", false);
    aBike.save();
    fullBikeList1.add(aBike);

    ArrayList<TimeSlot> newTimes = new ArrayList<>();

    ArrayList<Bike> newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    TimeSlot newTimeSlot = new TimeSlot("12 - 1 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("1 - 2 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("2 - 3 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("3 - 4 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("4 - 5 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("5 - 6 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("6 - 7 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("7 - 8 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("8 - 9 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("9 - 10 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("10 - 11 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("11 am - 12 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("12 - 1 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("1 - 2 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("2 - 3 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("3 - 4 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("4 - 5 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("5 - 6 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newTimeSlot = new TimeSlot("6 - 7 pm", fullBikeList, false);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newTimeSlot = new TimeSlot("7 - 8 pm", fullBikeList1, false);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("8 - 9 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("9 - 10 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("10 - 11 pm", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    newBikeList = new ArrayList<>();
    for (int i = 1; i <= 7; i++) {
        Bike newBike = new Bike(i, "", true);
        newBike.save();
        newBikeList.add(newBike);
    }
    newTimeSlot = new TimeSlot("11 pm - 12 am", newBikeList, true);
    newTimeSlot.save();
    newTimes.add(newTimeSlot);

    Day newDay = new Day("March 25th, 2015", newTimes);
    newDay.save();
    Log.i("PARSE SETUP", "March 25th, 2015 DONE!");
} catch (ParseException e) { }
