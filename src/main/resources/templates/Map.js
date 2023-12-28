import React, { useEffect, useState } from 'react'

export default function Map(props) {

    console.log(`콘솔1번 props.latitude: ${props.latitude}`)

    const { kakao } = window
    const lat = props.latitude
    const long = props.longitude

    useEffect(() => {
        console.log(`콘솔2번 props.latitude: ${props.latitude}`)
        const container = document.getElementById('map')
        const options = {
            center: new kakao.maps.LatLng(lat, long),
            level: 3,
        }
        const map = new kakao.maps.Map(container, options)

        // 지도에 마커를 생성하고 표시한다
        var marker = new kakao.maps.Marker({
            position: new kakao.maps.LatLng(lat, long), // 마커의 좌표
            map: map, // 마커를 표시할 지도 객체
        })
    }, [props])

    return (
        <>
            <div id="map" style={{ width: '750px', height: '350px' }}></div>
        </>
    )
}