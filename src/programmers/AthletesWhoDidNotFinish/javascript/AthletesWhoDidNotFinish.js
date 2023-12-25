function test(){
    const participant = ["leo", "kiki", "eden"]
    const completion = ["eden", "kiki"]

    const expAns= "leo"
    const realAns= solution(participant, completion)

    console.log(realAns)
    console.log(realAns===expAns)

}

test();

function solution(participant, completion) {
    let hash = {}
    participant.forEach((par) => {
        hash[par] = hash[par] ? hash[par] +1 : 1
    })
    completion.forEach((par) => {
        hash[par] = hash[par] -1
    })

    for(let key in hash) {
        if(hash[key] >= 1) {
            return key
        }
    }

}